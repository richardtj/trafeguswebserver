package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.TransportadorItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.TransportadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.TransportadorDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class TransportadorItemRendererController
	{
		public function TransportadorItemRendererController()
		{
		}
		public var view:TransportadorItemRendererView;
		public function popUp(param:String):void
		{
			var transportadorDetails:TransportadorDetails = new TransportadorDetails();
			transportadorDetails.codigo = param;
			transportadorDetails.addEventListener(TransportadorSelecionadoEvent.TRANSPORTADOR_SELECIONADO_EVENT,this.transportadorSelecionadoEventHandler);
			PopUpManager.addPopUp(transportadorDetails,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(transportadorDetails);
		}
		private function transportadorSelecionadoEventHandler(event:TransportadorSelecionadoEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}