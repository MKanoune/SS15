import java.io.InputStream;
import java.util.Properties;

public class ChangeConditions {
	
	private long basicChargeLimit = 100000;
	
	public long getBasicChargeLimit() {
		return basicChargeLimit;
	}

	public void setBasicChargeLimit(long basicChargeLimit) {
		this.basicChargeLimit = basicChargeLimit;
	}

	public long getBasicCharge() {
		return basicCharge;
	}

	public void setBasicCharge(long basicCharge) {
		this.basicCharge = basicCharge;
	}

	public float getPercantageCharge() {
		return percantageCharge;
	}

	public void setPercantageCharge(float percantageCharge) {
		this.percantageCharge = percantageCharge;
	}

	private long basicCharge;
	
	private float percantageCharge;
	
	public ChangeConditions(long basicCharge, float percentageCharge){
		this.basicCharge = basicCharge;
		this.percantageCharge = percentageCharge;
	}
	
	public ChangeConditions load(){
		InputStream inputStream;
		try{
			Properties props = new Properties();
			String name = "config.properties";
			
			inputStream = getClass().getResourceAsStream(name);
			props.load(inputStream);
			long basic = Long.parseLong(props.getProperty("basicCharge"));
			float percantage = Float.parseFloat(props.getProperty("percentageCharge"));
			
			ChangeConditions conditions = new ChangeConditions(basic,percantage);
			return conditions;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}
