package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.SMItemRenderer;
	import br.com.chapecosolucoes.trafegusweb.client.view.SMGrid;
	
	import flash.display.DisplayObject;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class SMItemRendererController
	{
		public function SMItemRendererController()
		{
		}
		public var view:SMItemRenderer;
		public function popUp(placaVeiculo:String):void
		{
			var smGrid:SMGrid = new SMGrid();
			smGrid.placaVeiculo = placaVeiculo;
			PopUpManager.addPopUp(smGrid,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(smGrid);
		}
	}
}