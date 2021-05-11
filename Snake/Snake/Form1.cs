using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Snake
{  
    public partial class Form1 : Form{
       

        private int direction = 2;
        private int scor = 0;
        private Graphics graphics;
        private Timer timer = new Timer(); 
        private Snake snake;
        private Food food;
        private int time;


        public Form1()
        {
            
            time = 200;
            InitializeComponent();
            button2.Visible = false;
            snake = new Snake();
            food = new Food();
            KeyPreview = true;
            food.generateFood(snake);
            timer.Interval = time;
            timer.Tick += Update;
        }

        public void Update(object sender, EventArgs args)
        {
            
            snake.move(direction);
            for (int i = 1; i < snake.body.Length; i++)
            {
                if (snake.body[0].IntersectsWith(snake.body[i]))
                    restart("lost");
            }
            if(snake.body[0].IntersectsWith(food.square))
            {
                snake.grow();
                time = time - 10;
                timer.Interval = time;
                food.generateFood(snake);
                scor++;
                label1.Text = "Scor: " + scor;
            }
            if (snake.body[0].X < 0 || snake.body[0].X > 500 || snake.body[0].Y < 0 || snake.body[0].Y > 480)
            {
                restart("lost");
            }
            if (snake.body.Length > 40)
                restart("won");
           
                panel1.Refresh();
            this.Invalidate();
        }

        public void restart(String s)
        {
            timer.Stop();
            
            direction = 2;
            time = 200;

            button2.Visible = true;
            button2.Text = "You " + s + "!";
            scor = 0;
            timer.Interval = time;
            snake = new Snake();
            food = new Food();
            food.generateFood(snake);
            button1.Text = "Restart Game";
            panel1.Refresh();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            button2.Visible = false;
            if (button1.Text == "Start game" || button1.Text == "Restart Game")
            {
                label1.Text = "Scor: " + scor;
                button1.Text = "Pause game";
                timer.Start();
            }
            else
            {
                timer.Stop();
                button1.Text = "Start game";
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            graphics = this.panel1.CreateGraphics();
            snake.color(graphics, direction);
            food.drawFood(graphics);
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            e.SuppressKeyPress = true; 
            if (e.KeyData == Keys.Up && direction != 2)
            {
                direction = 0;
            }
            else if (e.KeyData == Keys.Left && direction != 3)
            {
                direction = 1;
            }
            else if (e.KeyData == Keys.Down && direction != 0)
                direction = 2;
            else if (e.KeyData == Keys.Right && direction != 1)
                direction = 3;
        }

        
    }
}
