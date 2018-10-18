grammar LA;



IDENT	:	('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;

CADEIA	:	'"'  ~('\n' | '\r' | '\'')  * '\'' | '"' ~('\n' | '\r' | '"') * '"';

NUM_INT: ('-')? '0'..'9' ('0'..'9')* ;
NUM_REAL: NUM_INT  ('.' '0'..'9' ('0'..'9')*)?;

COMMENT : '{'.*?'}' -> skip;
COMMENTNFECHADO: '{' .*? ;
WS	:	(' ' | '\t' | '\r' | '\n') -> skip;
ERROCHAR:.;

op1 : '+' | '-';
op2 : '*' | '/';
op3 : '%';
op_logico_1 : 'ou';
op_logico_2 : 'e';
op_relacional : '=' | '<>' | '>=' | '<=' | '>' | '<';
tipo_basico : 'literal' | 'inteiro' | 'real' | 'logico';


programa : declaracoes 'algoritmo' corpo 'fim_algoritmo';

declaracoes : decl_local_global*;

decl_local_global : declaracao_local | declaracao_global;

declaracao_local : 'declare' variavel # declaracao_local_variavel |
                    'constante' nome=IDENT ':' tipo_basico '=' valor_constante  # declaracao_local_constante|
                    'tipo' nome1=IDENT ':' tipo # declaracao_local_tipo;

variavel : identificador_var ( ',' (identificador_var | IDENT) )* ':' tipo;

identificador_var : nome2=IDENT ('.' IDENT)* dimensao;

identificador : nome3=IDENT ('.' IDENT)* dimensao;

dimensao : ('[' exp_aritmetica ']')*;

tipo : registro | tipo_estendido;

tipo_basico_ident : tipo_basico | nome4=IDENT;

tipo_estendido : '^'? tipo_basico_ident;

valor_constante : CADEIA # valor_constante_cadeia
                    | NUM_INT # valor_constante_int
                    | NUM_REAL # valor_constante_real
                    | 'verdadeiro' # valor_constante_verdadeiro
                    | 'falso' #valor_constante_falso;

registro : 'registro' variavel* 'fim_registro';

declaracao_global : 'procedimento' IDENT '(' parametros? ')'  declaracao_local* cmd* 'fim_procedimento' # declaracao_global_procedimento
                | 'funcao' IDENT '(' parametros?  ')' ':' tipo_estendido declaracao_local* cmd* 'fim_funcao' # declaracao_global_funcao;


parametro : 'var'? identificador (',' identificador)* ':' tipo_estendido;


parametros : parametro (',' parametro)*;

corpo : declaracao_local* cmd*;


cmd : cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto | cmdFaca | cmdAtribuicao | cmdChamada | cmdRetorne;

cmdLeia : 'leia' '(' '^'? identificador (',' '^'? identificador)* ')';

cmdEscreva : 'escreva' '(' expressao ( ',' expressao)* ')';


cmdSe : 'se' expressao 'entao' cmd* ( 'senao' cmd* )? 'fim_se';

cmdCaso : 'caso' exp_aritmetica 'seja' selecao ( 'senao' (cmd*) )? 'fim_caso';


cmdPara : 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd*) 'fim_para';


cmdEnquanto : 'enquanto' expressao 'faca' cmd* 'fim_enquanto';


cmdFaca : 'faca' cmd*'ate' expressao;


cmdAtribuicao : '^'? identificador '<-' expressao;

cmdChamada : IDENT '(' expressao (','expressao)* ')';


cmdRetorne : 'retorne' expressao;


selecao : item_selecao*;


item_selecao: constantes ':' cmd*;


constantes : numero_intervalo (',' numero_intervalo)*;


numero_intervalo : op_unario? NUM_INT ('..' op_unario? NUM_INT)?;

op_unario : '-';

exp_aritmetica : termo1=termo (op1 outrosTermos+=termo)* ;
termo : fator1=fator (op2 outrosFatores+=fator)*;

fator : parcela1=parcela (op3 outrasParcelas+=parcela)*;
parcela : op_unario? parcela_unario | parcela_nao_unario;

parcela_unario : parcela_unario_identificador | parcela_unario_ident | parcela_unario_int | parcela_unario_real | parcela_unario_exp;

parcela_unario_identificador: '^'? identificador;
parcela_unario_ident: IDENT '(' expressao (',' expressao)* ')';
parcela_unario_int: NUM_INT ;
parcela_unario_real: NUM_REAL;
parcela_unario_exp: '(' expressao ')' ;

parcela_nao_unario : '&' identificador | oi=CADEIA ;


exp_relacional : exp1=exp_aritmetica (op_relacional outrasExpressoes=exp_aritmetica)?;

expressao : termo_logico1=termo_logico (op_logico_1 outrosTermos_Logicos+=termo_logico)*;


termo_logico : fator_logico1=fator_logico (op_logico_2 outrosFatores_Logicos+=fator_logico)*;
fator_logico : 'nao'? parcela_logica;
parcela_logica : ('verdadeiro' | 'falso') | exp_relacional;