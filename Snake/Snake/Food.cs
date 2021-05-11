using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Snake
{
    public class Food
    {
        public Rectangle square;
        protected int x, y, width = 20, height = 20;

        public Food()
        {

        }

        protected int check_if_valid(Snake snake, Rectangle rec)
        {
            for (int i = 0; i < snake.body.Length; i++)
                if (snake.body[i].IntersectsWith(rec))
                    return 0;
            return 1;
        }

        public void generateFood(Snake snake)
        {
            Random r = new Random();
            x = r.Next(1, 26) * 20;         // pentru ca mancarea sa nu mai apara intre randuri
            y = r.Next(1, 25) * 20;         // se cosidera ca ii ca o matrice de 32 pe 32
            square = new Rectangle(x, y, width, height);
            if (check_if_valid(snake, square) == 0)
                generateFood(snake);
            
        }
        public void drawFood(Graphics graph)
        {
            graph.FillEllipse(Brushes.Purple, square);
        }
    }
}
