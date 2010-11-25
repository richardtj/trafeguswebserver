package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.VehicleEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehiclesView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;

	public class VehiclesController
	{
		public function VehiclesController()
		{
			//MainModel.getInstance().dpPosicao.filterFunction = veiculosFilterFunction;
		}
		public var view:VehiclesView;
		public function veiculosFilterFunction(item:Object):Boolean
		{
			return (String(PosicaoVeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) || 
				   (String(PosicaoVeiculoVO(item).cpfMotoristaPrincipal).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) ||
				   (String(PosicaoVeiculoVO(item).embarcador).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) ||
				   (String(PosicaoVeiculoVO(item).gpsDescSis).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) ||
				   (String(PosicaoVeiculoVO(item).motoristaPrincipal).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) ||
				   (String(PosicaoVeiculoVO(item).numeroTerminal).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) ||
				   (String(PosicaoVeiculoVO(item).tipoVeiculo).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0) ||
				   (String(PosicaoVeiculoVO(item).versaoTecnologia).toUpperCase().search(MainModel.getInstance().veiculoSelecionado.toUpperCase()) >= 0);
		}
		public function solicitaListaVeiculos():void
		{
			TrafegusWS.getIntance().solicitaListaVeiculos(this.veiculosRecebidosHandler);
		}
		public function solicitaDadosGrid():void
		{
			TrafegusWS.getIntance().solicitaDadosGrid(this.dadosGridRecebidosHandler);
		}
		public function veiculoSelecionadoHandler(event:MouseEvent):void
		{
			MainModel.getInstance().posicaoVeiculoVO = PosicaoVeiculoVO(event.currentTarget.selectedItem);
			this.view.dispatchEvent(new VehiclesEvent(VehiclesEvent.VEHICLE_SELECTED_EVENT,event.currentTarget.selectedIndex,VehicleEnum.LIST));
		}
		private function veiculosRecebidosHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().posVeiculosArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var dataPos:PosicaoVeiculoVO = new PosicaoVeiculoVO(obj);
				MainModel.getInstance().posVeiculosArray.addItem(dataPos);
			}
			this.view.dispatchEvent(new VehiclesEvent(VehiclesEvent.VEHICLES_RECEIVED_EVENT));
		}
		private function dadosGridRecebidosHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().posVeiculosArray = new ArrayCollection();
			MainModel.getInstance().posVeiculosArray.filterFunction = veiculosFilterFunction;
			for each (var obj:Object in resultArray)
			{
				var dataPos:PosicaoVeiculoVO = new PosicaoVeiculoVO(obj);
				MainModel.getInstance().posVeiculosArray.addItem(dataPos);
			}
			this.view.dispatchEvent(new VehiclesEvent(VehiclesEvent.VEHICLES_RECEIVED_EVENT));
		}
	}
}