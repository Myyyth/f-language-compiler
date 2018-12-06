a:integer is 1;
d is func(c: integer): integer
do
    while c < 5 loop
        print(c);
        c := c + 1;
    end;
    return 0;
end;
z:integer is d(a);