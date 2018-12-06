powerOfTwo is func(c: integer, begin: integer): integer
do
    while c > 0 loop
        begin := begin * 2;
        c := c - 1;
    end;
    print(begin);
    return 0;
end;
z:integer is powerOfTwo(7, 1);