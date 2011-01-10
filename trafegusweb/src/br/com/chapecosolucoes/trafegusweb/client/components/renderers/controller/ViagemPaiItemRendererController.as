package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.ViagemPaiItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.ViagemPaiSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.ViagemPaiDetails;
	
	import flash.display.DisplayObject;
	import flash.events.MouseEvent;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class ViagemPaiItemRendererController
	{
		public function ViagemPaiItemRendererController()
		{
		}
		public var view:ViagemPaiItemRendererView;
		public function popUp():void
		{
			var viagemPaiDetails:ViagemPaiDetails = new ViagemPaiDetails();
			viagemPaiDetails.addEventListener(ViagemPaiSelecionadaEvent.VIAGEM_PAI_SELECIONADA_EVENT,this.viagemPaiSelecionadaEventHandler);
			PopUpManager.addPopUp(viagemPaiDetails,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(viagemPaiDetails);
		}
		private function viagemPaiSelecionadaEventHandler(event:ViagemPaiSelecionadaEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}