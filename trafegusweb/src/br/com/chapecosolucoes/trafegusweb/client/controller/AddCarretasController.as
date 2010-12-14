package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddCarretasView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.events.DragEvent;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;

	public class AddCarretasController
	{
		public function AddCarretasController()
		{
		}
		public var view:AddCarretasView;
		public function leftToRightEventHandler():void
		{
			for each(var vo:VeiculoVO in this.view.grid.selectedItems)
			{
				var veiculoVO:VeiculoVO = VeiculoVO(MainModel.getInstance().carretasDisponiveisArray.removeItemAt(MainModel.getInstance().carretasDisponiveisArray.getItemIndex(vo)));
				MainModel.getInstance().carretasSelecionadasArray.addItem(veiculoVO);
			}
		}
		public function rightToLeftEventHandler():void
		{
			for each(var vo:VeiculoVO in this.view.grid1.selectedItems)
			{
				var veiculoVO:VeiculoVO = VeiculoVO(MainModel.getInstance().carretasSelecionadasArray.removeItemAt(MainModel.getInstance().carretasSelecionadasArray.getItemIndex(vo)));
				MainModel.getInstance().carretasDisponiveisArray.addItem(veiculoVO);
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
		public function solicitaListaCarretasDisponiveis():void
		{
			if(MainModel.getInstance().carretasDisponiveisArray.length == 0 && MainModel.getInstance().carretasSelecionadasArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaCarretasDisponiveis(solicitaListaCarretasDisponiveisResultHandler);
			}
		}
		public function atualizaListaCarretasDisponiveis():void
		{
			TrafegusWS.getIntance().solicitaListaCarretasDisponiveis(solicitaListaCarretasDisponiveisResultHandler);
		}
		private function solicitaListaCarretasDisponiveisResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().carretasDisponiveisArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var veiculo:VeiculoVO = new VeiculoVO(obj);
				MainModel.getInstance().carretasDisponiveisArray.addItem(veiculo);
			}
		}
		public function carretasFilterFunction(item:Object):Boolean
		{
			return (String(VeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(VeiculoVO(item).desc).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function cancelarSelecao():void
		{
			var length:int = MainModel.getInstance().carretasSelecionadasArray.length;
			for (var i:int=0;i < length;i++)
			{
				var veiculoVO:VeiculoVO = VeiculoVO(MainModel.getInstance().carretasSelecionadasArray.removeItemAt(0));
				MainModel.getInstance().carretasDisponiveisArray.addItem(veiculoVO);
			}
			this.closeHandler();
		}
	}
}