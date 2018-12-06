b:integer is 1;
c is func():integer
do
    print("Hello from c");
    return 0;
end;
d is func(a: func():integer):integer
do
    print("Run in d");
    a();
    return 0;
end;
e: integer is d(c);
