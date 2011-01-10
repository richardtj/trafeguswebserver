package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.LocalItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.LocalDetailsView;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class LocalItemRendererController
	{
		public function LocalItemRendererController()
		{
		}
		public var view:LocalItemRendererView;
		public function popUp(codigo:String):void
		{
			var localDetails:LocalDetailsView = new LocalDetailsView();
			localDetails.codigo = codigo;
			localDetails.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,localSelecionadoEventHandler);
			PopUpManager.addPopUp(localDetails,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(localDetails);
		}
		private function localSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			this.view.dispatchEvent(event);
		}
	}
}