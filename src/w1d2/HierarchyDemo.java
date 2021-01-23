package w1d2;

public class HierarchyDemo {
	
	public void run() {
		// nothing...
	}

	interface Shape {
		double calculateArea();
		void display();
	}
	
	class Rectangle implements Shape {
		double w;
		double h;
		
		@Override
		public double calculateArea() {
			return w*h;
		}

		@Override
		public void display() {
			// nothing
		}
		
	}
	
	class Circle implements Shape {
		double r;
		
		@Override
		public double calculateArea() {
			return Math.PI*r*r;
		}
		@Override
		public void display() {/*nothing*/} 
	}
	
	class Triangle implements Shape {
		double a;
		double b;
		double c;
		
		@Override
		public double calculateArea() {
			double p = (a+b+c)/2.0;
			return Math.sqrt(p*(p-a)*(p-b)*(p-c));
		}
		@Override
		public void display() {/*nothing*/} 
		
	}
	

}
