#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* foo (int a1, int b1[], int *c1)
{
  int d1 = a1 + *c1;
  int *e1;
  
  e1 = malloc (sizeof(int));

  printf ("5) Addresses of arguments/variables of foo:\n");
  printf ("   Update your stack sketch.\n");
  printf ("     &a1: %d\n", &a1);
  printf ("     &b1: %d\n", &b1);
  printf ("     &c1: %d\n", &c1);
  printf ("     &d1: %d\n", &d1);
  printf ("     &e1: %d\n\n", &e1);

  printf ("6) Values of arguments/variables in foo:\n");
  printf ("   Include these on your stack sketch as well.\n");
  printf ("     a1: %d\n", a1);
  printf ("     b1: %d\n", b1);
  printf ("     c1: %d\n", c1);
  printf ("     d1: %d\n", d1);
  printf ("     e1: %d\n\n", e1);

  printf ("7) *c1 == %d, why?  Explain using your stack drawing.\n\n", *c1); 
  
  printf ("8) e1 is a reference to an integer, much like c1.  Why is e1 so\n ");
  printf ("   different in value?\n\n");

  return e1;
}


main ()
{
  int a = 5;
  int b[] = {8, 14, -7, 128, 12};
  int c = 10;
  int d = 14;

  printf ("1) Locations...\n");
  printf ("   Use these locations to sketch the stack.\n");
  printf ("     &a: %d\n", &a);
  printf ("      b: %d\n", b);
  printf ("     &c: %d\n", &c);
  printf ("     &d: %d\n\n", &d);
  
  printf ("2) Values:\n");
  printf ("   Why does *b == 8?\n");
  printf ("     a: %d\n", a);
  printf ("    *b: %d\n", *b);
  printf ("     c: %d\n", c);
  printf ("     d: %d\n\n", d);

  printf ("3) Notice that the following increase by 4 each, why?\n");
  printf ("     &(b[0]): %d\n", &(b[0]));
  printf ("     &(b[1]): %d\n", &(b[1]));
  printf ("     &(b[2]): %d\n", &(b[2]));
  printf ("     &(b[3]): %d\n\n", &(b[3]));

  printf ("4) Pointers can be added, but the addition might have interesting results.\n");
  printf ("   Explain why b + 1 != b + 1 in the normal way of thinking about addition.\n");
  printf ("     b: %d\n", b);
  printf ("     b+1: %d\n", b+1);
  printf ("     b+2: %d\n", b+2);
  printf ("     b+3: %d\n\n", b+3);
  
  foo (a, b, &c);
}
