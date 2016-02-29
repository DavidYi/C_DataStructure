#include <stdio.h>
#include <stdlib.h>
#include "point.h"

int main(){
  Point *p1;
  Point *p2;
  char temp1[40];

  p1 = createPoint (4, 20);
  p2 = createPoint (3, 4);

  movePoint (p1, 13, 37);

  dilatePoint (p2, 4);

  pointToString (p1, temp1);
  printf ("%s\n", temp1);
}
