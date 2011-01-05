package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.EmbarcadorItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.EmbarcadorDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

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
			PopUpManager.addPopUp(embarcadorDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(embarcadorDetails);
		}
		private function embarcadorSelecionadoEventHandler(event:EmbarcadorSelecionadoEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}