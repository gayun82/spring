package testJava;

public class SamsungTV implements TV {
	private Speaker speaker;
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("삼성TV전원을 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성TV전원을 끈다");
	}

	@Override
	public void volumeUp() {
		speaker.model();
		System.out.println("소리를 올린다");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성TV소리를 줄인다");
	}

}
