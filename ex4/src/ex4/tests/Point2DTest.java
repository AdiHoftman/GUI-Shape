package ex4.tests;

import java.awt.Point;
import java.util.Arrays;

import ex4.geometry.GeoShape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class Point2DTest {

	@Test
	void x(){
		Point2D p1 = new Point2D(-1,2);
		Point2D p2 = new Point2D(-1, 0);
		assertEquals(p1.x(), p2.x());
		assertNotEquals(1, p1.x());
	}

	@Test
	void y(){
		Point2D p1 = new Point2D(2,-3);
		Point2D p2 = new Point2D(3, -3);
		assertEquals(p1.y(), p2.y());
		assertNotEquals(3, p1.y());
	}



	@Test
	void add(){
		Point2D p1 = new Point2D(3,5);
		Point2D p2 = new Point2D(6,8);
		p2 = new Point2D(p2.add(p1));
		Point2D c = new Point2D(4,3);
		Point2D d = new Point2D(5, 10);
		d = new Point2D(d.add(c));
		assertEquals(new Point2D(9,13), p2);
		assertEquals(p2, d);
	}

	@Test
	void distance() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(5,6);
		double dist = p1.distance(p2);
		assertEquals(Math.sqrt(13), dist);
	}

	@Test
	void close2equals(){
		Point2D p1 = new Point2D(0,0);
		Point2D p2 = new Point2D(-1,-1);
		Point2D p3 = new Point2D(1,0);
		assertFalse(p1.close2equals(p2, -1));
		assertTrue(p1.close2equals(p3, 2.01));
	}

	@Test
	void vector(){
		Point2D p1 = new Point2D(1,-1);
		Point2D p2 = new Point2D(-2,4);
		Point2D p3 = new Point2D(3, -5);
		assertEquals(p3, p2.vector(p1));
	}

	@Test
	void move(){
		Point2D p1 = new Point2D(-5,-2);
		Point2D p2 = new Point2D(10,3);
		Point2D p3 = new Point2D(5,1);
		Point2D p4 = new Point2D(-5,1);
		p1.move(p2);
		assertEquals(p3, p1);
		assertNotEquals(p4,p1);
	}

	@Test
	void copy(){
		Point2D p1 = new Point2D(1,3);
		Point2D p2 = new Point2D(2,4);
		Point2D p3 = new Point2D(-1,-1);
		assertEquals(p3, p2.vector(p1));
		GeoShape g = p3.copy();
		assertEquals(p3, g);
	}

	@Test
	void getPoints(){
		Point2D p = new Point2D(1,9);
		Point2D[] p1 = new Point2D[1];
		p1[0] = p;
		Assertions.assertArrayEquals(p1, p.getPoints());
	}
}
