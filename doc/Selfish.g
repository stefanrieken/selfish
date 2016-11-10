grammar Selfish;

start_rule	: code;

/* Antlr3 compatible grammar for Selfish             */
/* Note: for reference only. Parser written by hand. */

/* Unit: ExpressionParser */

code		: (expressionlist (';' expressionlist)*)? ;
expressionlist	: expression ((',')? expression)* ; /* space separated causes dilemma: 'a (c*d);': arglist or precedence? */
expression	: binExpression;


/* Unit: InvocationParser */

binExpression	: dotExpression ({binInvocation}? binInvocation)* ;
binInvocation	: BNAME dotExpression ;

dotExpression	: (precedence|mention ) ( dotInvocation )* ;
dotInvocation	: '.' (BNAME|NAME)  {arglist}? arglist ;

arglist		: '(' expressionlist ')' ;
precedence	: '(' expressionlist ')' ;


/* Unit: DefinitionParser */

mention		: (attr)? (namedDef|literal) {arglist}? arglist ;
namedDef	: (NAME|BNAME) ( staticDef )? ; /* TODO allow context definition at start of expressionList : ".bla : {}" */
staticDef	: ':' linkReference | literal;
linkReference	: ( '/' NAME )+ ;
attr		: '@' (NAME | block);		/* manual note: only static definitions allowed in this particular block */


/* Unit: LiteralParser */
literal		: block | NUMBER | STRING ;
block		: '{' code '}' ;


/* Unit: Lexer */

NUMBER		: ('0'..'9')+ ;
STRING		: '"' ( ~'"' )* '"' ;		/* todo escape */
NAME		: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')* ;
BNAME		: ('!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '|' | '~' )+ ;


