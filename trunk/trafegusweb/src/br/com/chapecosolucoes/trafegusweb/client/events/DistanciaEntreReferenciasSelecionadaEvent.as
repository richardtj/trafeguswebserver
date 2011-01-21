package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciasVO;
	
	import flash.events.Event;
	
	public class DistanciaEntreReferenciasSelecionadaEvent extends Event
	{
		public static const DISTANCIA_ENTRE_REFERENCIAS_SELECIONADA_EVENT:String = "distanciaEntreReferenciasSelecionadaEvent";
		public static const DISTANCIA_ENTRE_REFERENCIAS_ADICIONADA_EVENT:String = "distanciaEntreReferenciasAdicionadaEvent";
		public var distanciaEntreReferenciasVO:DistanciaDeAteReferenciasVO;
		public function DistanciaEntreReferenciasSelecionadaEvent(type:String,distanciaEntreReferenciasVO:DistanciaDeAteReferenciasVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.distanciaEntreReferenciasVO = distanciaEntreReferenciasVO;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new DistanciaEntreReferenciasSelecionadaEvent(type,distanciaEntreReferenciasVO,bubbles,cancelable);
		}
	}
}