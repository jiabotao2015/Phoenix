package PHoenix.API.Test.UtilTest;

import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.context.jts.JtsSpatialContext;
import com.spatial4j.core.distance.DistanceCalculator;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.jts.JtsPoint;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import PHoenix.API.Utils.GeoUtil;

public class GeoUtilTest {
	private static SpatialContext ctx;
	private static double EPS;
	public static final double DEG_90_AS_RADS = Math.PI / 2;

	public static void main(String[] args) {
		double a = distLawOfCosinesRAD(114.1,30,114,30);
		Polygon circle = GeoUtil.createCircle(114, 30, 10);
		Point pt = GeoUtil.CreatePoint(123, 30);
		boolean contain = circle.contains(pt);
		//double area = circle.getArea();
		System.out.print(contain);
		
	}

	public static double distLawOfCosinesRAD(double lat1, double lon1, double lat2, double lon2) {
		double dLon = lon2 - lon1;
		double cosB = (Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(dLon));
		return cosB;
		//return  Math.acos(cosB);

	}
	
	public static double distLawOfCosinesRAD2( double lat1, double lon1, double lat2, double lon2) { 

	    if (lat1 == lat2 && lon1 == lon2) return 0.0; 

	   // Get the m_dLongitude difference. Don't need to worry about 

	   // crossing 180 since cos (x) = cos (-x) 

	    double dLon = lon2 - lon1; 

	    double a = DEG_90_AS_RADS - lat1; 

	    double c = DEG_90_AS_RADS - lat2; 

	    double cosB = (Math.cos(a) * Math.cos(c)) + (Math.sin(a) * Math.sin(c) * Math.cos(dLon)); 

	    return  Math.acos(cosB);

	 }


}
