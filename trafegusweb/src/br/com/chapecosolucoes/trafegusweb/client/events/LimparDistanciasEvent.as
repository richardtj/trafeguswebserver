package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.LimparDistanciasVO;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	public class LimparDistanciasEvent extends Event
	{
		public static const LIMPAR_DISTANCIAS_EVENT:String = "limparDistanciasEvent";
		public var limparDistanciasArray:ArrayCollection;
		public function LimparDistanciasEvent(type:String,limparDistanciasArray:ArrayCollection, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.limparDistanciasArray = limparDistanciasArray;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new LimparDistanciasEvent(type,limparDistanciasArray,bubbles,cancelable);
		}
	}
}