package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.LimparDistanciasVO;
	
	import flash.events.Event;
	
	public class LimparDistanciasEvent extends Event
	{
		public static const LIMPAR_DISTANCIAS_EVENT:String = "limparDistanciasEvent";
		public var limparDistanciasVO:LimparDistanciasVO;
		public function LimparDistanciasEvent(type:String,limparDistanciasVO:LimparDistanciasVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.limparDistanciasVO = limparDistanciasVO;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new LimparDistanciasEvent(type,limparDistanciasVO,bubbles,cancelable);
		}
	}
}