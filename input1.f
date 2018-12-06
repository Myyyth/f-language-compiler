b:integer is 1;
c is func():integer
do
    print("Hello from c");
    return 0;
end;
d is func():integer
do
    a: func():integer => 3;
    t is a();
    return 0;
end;
e: integer is d(c);
