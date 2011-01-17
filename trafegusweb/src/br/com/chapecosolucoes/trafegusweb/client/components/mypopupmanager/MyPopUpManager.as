package br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	
	import flash.display.DisplayObject;
	
	import mx.core.IFlexDisplayObject;
	import mx.core.IFlexModuleFactory;
	import mx.managers.PopUpManager;
	
	public class MyPopUpManager
	{
		public function MyPopUpManager()
		{
		}
		public static function addPopUp(window:IFlexDisplayObject,
										parent:DisplayObject,
										modal:Boolean = false,
										childList:String = null,
										moduleFactory:IFlexModuleFactory = null):void
		{
			MainModel.getInstance().popupsArray.addItem(window);
			PopUpManager.addPopUp(window,parent,modal,childList,moduleFactory);
		}
		public static function centerPopUp(popUp:IFlexDisplayObject):void
		{
			PopUpManager.centerPopUp(popUp);
		}
		public static function removePopUp(popUp:IFlexDisplayObject):void
		{
			for(var i:int=0;i<MainModel.getInstance().popupsArray.length;i++)
			{
				if(MainModel.getInstance().popupsArray.getItemAt(i) == popUp)
				{
					MainModel.getInstance().popupsArray.removeItemAt(i);
				}
			}
			PopUpManager.removePopUp(popUp);
		}
	}
}