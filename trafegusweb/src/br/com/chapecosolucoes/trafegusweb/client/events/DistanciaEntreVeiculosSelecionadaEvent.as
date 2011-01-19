package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVeiculosVO;
	
	import flash.events.Event;
	
	public class DistanciaEntreVeiculosSelecionadaEvent extends Event
	{
		public static const DISTANCIA_ENTRE_VEICULOS_SELECIONADA_EVENT:String = "distanciaEntreVeiculosSelecionadaEvent";
		public var distanciaEntreVeiculosVO:DistanciaDeAteVeiculosVO;
		public function DistanciaEntreVeiculosSelecionadaEvent(type:String,distanciaEntreVeiculosVO:DistanciaDeAteVeiculosVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.distanciaEntreVeiculosVO = distanciaEntreVeiculosVO;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new DistanciaEntreVeiculosSelecionadaEvent(type,distanciaEntreVeiculosVO,bubbles,cancelable);
		}
	}
}