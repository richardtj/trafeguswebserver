package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.MotoristaVO;
	
	import flash.events.Event;
	
	public class SelectedDriverEvent extends Event
	{
		public static const SELECTED_DRIVER_EVENT:String = "selectedDriverEvent";
		public var motorista:MotoristaVO;
		public function SelectedDriverEvent(type:String,motorista:MotoristaVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.motorista = motorista;
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new SelectedDriverEvent(SELECTED_DRIVER_EVENT,motorista,bubbles);
		}
	}
}