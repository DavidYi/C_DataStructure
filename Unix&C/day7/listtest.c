#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include "intlist.h"

int main()
{
  int i, val;
  IntList *list1;

  list1 = ilCreate();

  printf ("\n\nAppend Test:\n");
  ilAppend (list1, 10);
  ilAppend (list1, 98);
  ilAppend (list1, 45);

  ilPrint (list1);
  
  printf ("List Size: %d\n", ilSize(list1));
  
  ilInsert (list1, 1, 20);
  ilInsert (list1, 0, 102);
  ilInsert (list1, 4, -99);
  
  printf ("\n\nInsert Test:\n");
  ilPrint (list1);
  printf ("List Size: %d\n", ilSize(list1));


  printf ("\n\nFind Test:\n");
  printf ("Find 102: %d\n", ilFind(list1, 102));
  printf ("Find 98: %d\n", ilFind(list1, 98));
  printf ("Find 45: %d\n", ilFind(list1, 45));
  
  printf ("\n\nGet Test:\n");
  printf ("Get 0: %d\n", ilGet(list1, 0));
  printf ("Get 3: %d\n", ilGet(list1, 3));
  printf ("Get 5: %d\n", ilGet(list1, 5));
  
  printf ("\n\nDelete Test 1 - Last element:\n");
  ilDelete (list1, 5);
  ilPrint (list1);

  printf ("\n\nDelete Test 1 - pos=2:\n");
  ilDelete (list1, 2);
  ilPrint (list1);

  printf ("\n\nDelete Test 1 - pos=0:\n");
  ilDelete (list1, 0);
  ilPrint (list1);
  
}
  
