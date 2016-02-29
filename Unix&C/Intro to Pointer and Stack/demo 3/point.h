#include <stdio.h>

struct point;

typedef struct point Point;

Point* createPoint (float x, float y);

void movePoint (Point *p, float dx, float dy);

void dilatePoint (Point *p, float factor);

char* pointToString (Point *p, char out[]);
