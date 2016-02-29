#include <stdio.h>

struct point {
  int x;
  int y;
};

typedef struct point Point;

void printPoint (Point p){
  printf ("(%d, %d)\n", p.x, p.y);
}

int main (){
  Point p1, p2;

  p1.x = 15;
  p1.y = 25;

  p2.x = -3;
  p2.y = 10;

  printPoint (p1);
  printPoint (p2);
}
