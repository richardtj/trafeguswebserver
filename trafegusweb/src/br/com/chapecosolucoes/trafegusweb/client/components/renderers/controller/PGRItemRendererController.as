package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.PGRItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.PGRDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class PGRItemRendererController
	{
		public function PGRItemRendererController()
		{
		}
		public var view:PGRItemRendererView;
		public function popUp(codigo:String):void
		{
			var pgrDetails:PGRDetails = new PGRDetails();
			pgrDetails.codigo = codigo;
			pgrDetails.addEventListener(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,pgrSelecionadoEventHandler);
			PopUpManager.addPopUp(pgrDetails,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(pgrDetails);
		}
		private function pgrSelecionadoEventHandler(event:PGRSelecionadoEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}