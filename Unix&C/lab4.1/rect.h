#include <stdio.h>

typedef struct point {
  float x;
  float y;
} Point;

typedef struct rect {
  Point pt1;
  Point pt2;
} Rect;


Rect* createRect (float x1, float y1, float x2, float y2);
/* Creates a new "Rectangle" object, defined by the coordinates x1,y1 and x2,y2.	
    It is the responsibility of the calling code to free the Rectangle when done.
   */
   
Rect* copyRect (Rect* r);
/* Creates a new "Rectangle" object that is a deep copy of the passed rectangle "r".
    It is the responsibility of the calling code to free the Rectangle when done.
   */
   
void move (Rect *r, float dx, float dy);
/* Translates rectangle "r" by dx and dy. */

void dilate (Rect *r, float factor);
/* Dilates rectangle "r" by "factor" about the origin. */
   
float getWidth (Rect *r);
/* Returns the absolute width of the rectangle "r", as defined 
   by the difference of the "x" coordinate values. */

float getHeight (Rect *r);
/* Returns the absolute height of the rectangle "r", as defined 
   by the difference of the "y" coordinate values. */

float getArea (Rect *r);
/* Returns the area of the rectangle. */

float getPerimeter (Rect *r);
/* Returns the perimeter of the rectangle. */

char* toString (Rect *r, char out[]);
/* Writes a string representation of Rectangle r to "out".
   "out" must be large enough for the string, 50 characters is plenty. 
   The function returns a reference to out to make printing easier. 
   */
