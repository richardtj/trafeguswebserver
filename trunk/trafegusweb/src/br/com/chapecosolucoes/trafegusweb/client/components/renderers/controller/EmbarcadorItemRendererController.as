package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.EmbarcadorItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.EmbarcadorDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class EmbarcadorItemRendererController
	{
		public function EmbarcadorItemRendererController()
		{
		}
		public var view:EmbarcadorItemRendererView;
		public function popUp(param:String):void{
			var embarcadorDetails:EmbarcadorDetails = new EmbarcadorDetails();
			embarcadorDetails.codigo = param;
			embarcadorDetails.addEventListener(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,embarcadorSelecionadoEventHandler);
			MyPopUpManager.addPopUp(embarcadorDetails,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(embarcadorDetails);
		}
		private function embarcadorSelecionadoEventHandler(event:EmbarcadorSelecionadoEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}