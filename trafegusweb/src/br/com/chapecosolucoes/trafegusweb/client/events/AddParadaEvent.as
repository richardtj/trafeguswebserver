package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO;
	
	import flash.events.Event;
	
	public class AddParadaEvent extends Event
	{
		public static const PARADA_ADICIONADA_EVENT:String = "paradaAdicionadaEvent";
		public var parada:ParadaVO;
		public function AddParadaEvent(type:String, parada:ParadaVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.parada = parada;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new AddParadaEvent(type,parada);
		}
	}
}