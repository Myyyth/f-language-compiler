incGenerator is func() do
 r is [1,2,3];
 avg is 0.5;
 for i in r do
  avg := avg + i;
 end;
 return r;
end

