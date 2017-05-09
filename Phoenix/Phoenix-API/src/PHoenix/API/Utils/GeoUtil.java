/**
 * JTS 用来判断几何图形之间的关系，长度面积什么的老老实实查数据库
 */
package PHoenix.API.Utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class GeoUtil {
	
	public static Point CreatePoint(double lat, double lon){
		GeometryFactory geometryFactory = new GeometryFactory();
		Coordinate coord = new Coordinate(lat, lon);
		Point point = geometryFactory.createPoint( coord );
		coord = null;
		geometryFactory = null;
		return point;
		
	}
	
	public static Geometry createPointByWKT(String wkt){
		//GeometryFactory geometryFactory = new GeometryFactory();
		WKTReader reader = new WKTReader();
		Geometry geom = null;
		try {
			geom =  reader.read(wkt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return geom;
	}
	
	public static Polygon createCircle(double lat, double lon, double radius) {
		int sides = 100;// 圆上点个数；
		GeometryFactory geometryFactory = new GeometryFactory();
		Coordinate coords[] = new Coordinate[sides + 1];
		for (int i = 0; i < sides; i++) {
			double angle = ((double) i / (double) sides) * Math.PI * 2.0;
			double dx = Math.cos(angle) * radius;
			double dy = Math.sin(angle) * radius;
			coords[i] = new Coordinate((double) lat + dx, (double) lon + dy);
		}
		coords[sides] = coords[0];
		LinearRing ring = geometryFactory.createLinearRing(coords);
		Polygon circle = geometryFactory.createPolygon(ring, null);
		return circle;

	}
	
	public static Polygon createCircle(Point center,Point pt){
		double radius = center.distance(pt);
		double lat = center.getX();
		double lon = center.getY();
		int sides = 36;
		GeometryFactory geometryFactory = new GeometryFactory();
		Coordinate coords[] = new Coordinate[sides + 1];
		for (int i = 0; i < sides; i++) {
			double angle = ((double) i / (double) sides) * Math.PI * 2.0;
			double dx = Math.cos(angle) * radius;
			double dy = Math.sin(angle) * radius;
			coords[i] = new Coordinate((double) lat + dx, (double) lon + dy);
		}
		coords[sides] = coords[0];
		LinearRing ring = geometryFactory.createLinearRing(coords);
		Polygon circle = geometryFactory.createPolygon(ring, null);
		return circle;
	}

}
