MULTIPLY(x, y, n) 
   IF (n = 1)
      RETURN x * y.
   ELSE
      m ← ⎡ n / 2 ⎤.
      a ← ⎣ x / 2^m ⎦; b ← x mod 2^m.
      c ← ⎣ y / 2^m ⎦; d ← y mod 2^m.
      e ← MULTIPLY(a, c, m).
      f ← MULTIPLY(b, d, m).
      g ← MULTIPLY(b, c, m).
      h ← MULTIPLY(a, d, m).
      RETURN 2^(2m)*e + 2^m*(g + h) + f.