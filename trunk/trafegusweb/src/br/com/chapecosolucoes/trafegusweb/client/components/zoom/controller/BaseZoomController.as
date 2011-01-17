package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.core.IFlexDisplayObject;
	import mx.managers.PopUpManager;

	public class BaseZoomController
	{
		public function BaseZoomController()
		{
		}
		public var view:Object;
		public function closeHandler():void
		{
			MyPopUpManager.removePopUp(IFlexDisplayObject(this.view));
		}
		public function keyDownEventHandler(event:KeyboardEvent):void
		{
			if(event.keyCode == Keyboard.ESCAPE)
			{
				this.closeHandler();
			}
		}
	}
}