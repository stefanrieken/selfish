grammar Selfish;

start_rule	: code;

/* Antlr3 compatible grammar for Selfish             */
/* Note: for reference only. Parser written by hand. */

/* Unit: ExpressionParser */

code		: (expressionlist (';' expressionlist)*)? ;
expressionlist	: expression ((',')? expression)* ; /* space separated causes dilemma: 'a (c*d);': arglist or precedence? (answer: prefer arglist. See further below) */
expression	: binExpression;


/* Unit: InvocationParser */

binExpression	: dotExpression ({binInvocation}? binInvocation)* ;
binInvocation	: BNAME dotExpression ;

dotExpression	: (precedence|mention ) ( dotInvocation )* ;
dotInvocation	: {'.'}? '.' (BNAME|NAME)  {arglist}? arglist ; /* antlr3 specific syntax to direct ambiguity: if arglist follows, interpret as arglist */

precedence	: '(' expressionlist ')' ;
arglist		: '(' expressionlist ')' ;


/* Unit: DefinitionParser */

mention		: (attr)? (namedDef|literal) {arglist}? arglist ; /* arglist == implicit 'self'-based execution */
namedDef	: ('.')? (NAME|BNAME) ( staticDef )? ; /* allow dot-based context definition at start of expressionList : ".bla : {}" */
staticDef	: ':' linkReference | literal;
linkReference	: '/'? (NAME|BNAME) ( '/' (NAME|BNAME) )* ;
attr		: '@' ( ((NAME|BNAME) {staticDef}? staticDef) | block ); /* unsure why Antlr thinks staticDef is ambiguous here. Also: note that in practice 'block' may only hold static definitions */


/* Unit: LiteralParser */
literal		: block | NUMBER | STRING ;
block		: '{' code '}' ;


/* Unit: Lexer */

NUMBER		: ('0'..'9')+ ;
STRING		: '"' ( ~'"' )* '"' ;		/* todo escape */
NAME		: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')* ;
BNAME		: ('!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '|' | '~' )+ ;


