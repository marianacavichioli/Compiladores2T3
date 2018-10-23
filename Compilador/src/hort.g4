//TODO: colocar o preparar solo dentro do corpo tambem, para fazer depois de colher

grammar hort;

IDENT   :  ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;
NUM_INT : ('-')? '0'..'9' ('0'..'9')*;

MES31 : '1'|'3'|'5'|'7'|'8'|'10'|'12';
MES30 : '2'|'4'|'6'|'9'|'11';

ANO : ('0'..'9')('0'..'9')('0'..'9')('0'..'9');

//DATA : (('0')('1'..'9') '/' (MES30 | MES31) '/' ANO)
//		|(('1'..'2')('0'..'9') '/' (MES30 | MES31) '/' ANO)
//		|(('3')('0') '/' (MES30 | MES31) '/' ANO)
//		|(('3')('1') '/' MES31 '/' ANO);

estacao : 'verao' | 'primavera' | 'inverno' | 'outono';


WS	:	(' ' | '\t' | '\r' | '\n') -> skip;
ERROCHAR:.;

semente : 'hortelã' | 'alface' | 'abobora' | 'abobrinha' | 'couve'| 'beterraba' | 'batata'| 'morango' ;
intensidade : 'pouco' | 'muito';
op_data : 'Dia' | 'Mês' | 'Ano' ;
slot: 'slot1'| 'slot2'| 'slot3' | 'slot4' | 'todos';

horta: 'Horta' IDENT ':' declaracoes  corpo 'Fim horta' ;

declaracoes : 'Estacao' ':' estacao  'Local' ':' local=IDENT ;

corpo : preparar_solo (cmd | cmdPara)*;

preparar_solo : 'Preparar solo' ':' (acao_regar | acao_capinar | acao_adubar)* ;

cmd : periodo_tempo ':' acao* ;

periodo_tempo : op_data NUM_INT;

acao: acao_plantar | acao_regar | acao_colher | acao_capinar | acao_adubar ;

acao_plantar : 'Plantar' semente slot ;

acao_regar : 'Regar' intensidade slot ;

acao_colher : 'Colher' slot ;

acao_capinar : 'Capinar' slot ;

acao_adubar : 'Adubar' slot ;

cmdPara : 'para' op_data NUM_INT 'ate' op_data NUM_INT 'faca' (acao*) 'fim_para';

