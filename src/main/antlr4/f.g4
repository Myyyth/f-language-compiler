grammar f;

program
   : declaration (';' declaration)*
   ;

declaration
   : IDENTIFIER (':' type)? ('is' expression)?
   ;

IDENTIFIER
   : [a-zA-Z][a-zA-Z0-9]*
   ;

expressions
   : expression (',' expression)*
   ;

expression
   : relation (('and' | 'or' | 'xor') relation)?
   ;

relation
   : factor (('<' | '<=' | '>' | '>=' | '=' '/=') factor)?
   ;

factor
   : term (('+' | '-') term)*
   ;

term
   : unary (('*' | '/') unary)*
   ;

unary
   : (('+' | '-') secondary)?
   ;

secondary
   : primary (tail)*
   ;

primary
   : elementary
   | function
   | tuple
   | map
   | list
   | '(' expression ')' 
   ;

tail
   : '(' (expressions)? ')'
   | '[' expression ']'
   | '.' IDENTIFIER
   | '.' INTEGERLITERAL
   ;

INTEGERLITERAL
   : '0'
   | [1-9] [0-9]*
   ;

elementary
   : 'false'
   | 'true'
   | 'INTEGERLITERAL'
   | 'REALLITERAL'
   | 'RATIONALLITERAL'
   | 'COMPLEXLITERAL'
   | 'STRINGLITERAL'
   | 'IDENTIFIER'
   ;

REALLITERAL
   : [0-9]+ '.' [0-9]+
   ;

WS
   : [ \t\r\n] -> skip
   ;

RATIONALLITERAL
   : [0-9]+ '\\' [0-9]+
   ;

STRINGLITERAL
   : '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"'
   ;

COMPLEXLITERAL
   : [0-9]+([.][0-9])? 'i' [0-9]+([.][0-9])?
   ;

function
   : 'func' '(' (parameters)? ')' (':' type)? body
   ;

parameters
   : declaration (',' declaration)*
   ;

body
   : 'do' statements 'end'
   | '=>' expression
   ;

tuple
   : '[' (tupleelement (',' tupleelement)*)?
   ;

tupleelement
   : (IDENTIFIER 'is')? expression
   ;

map
   : '{' (mapelement (',' mapelement)*)? '}'
   ;

mapelement
   : expression ':' expression
   ;

list
   : '(' (expressions)? ')'
   ;

type
   : ('bool' | 'integer' | 'real')
   | ('rational' | 'complex' | 'string')
   | 'func' '(' (type (',' type)*)? ')' (':' type)?
   | '{' '}'
   | '[' type ':' type ']'
   | '(' type ')'
   ;

statements
   : statement (';' statement)*
   ;

statement
   : assignmentorcall
   | conditional
   | loop
   | 'return' (expression)?
   | 'break'
   | declaration
   ;

assignmentorcall
   : secondary (':=' expression)?
   ;

conditional
   : 'if' expression 'then' statements ('else' statements)? 'end'
   ;

loop
   : 'for' (IDENTIFIER 'in')? expression ('..' expression)? loopbody
   | ('while' expression)? loopbody
   ;

loopbody
   : 'loop' statements 'end'
   ;


