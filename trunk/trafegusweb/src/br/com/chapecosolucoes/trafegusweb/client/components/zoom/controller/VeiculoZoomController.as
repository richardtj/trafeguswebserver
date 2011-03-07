package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PopupButtonEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.CadastroCavalosView;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehicleDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.events.ListEvent;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class VeiculoZoomController
	{
		public function VeiculoZoomController()
		{
		}
		public var view:VeiculoZoom;
		public function solicitaListaVeiculos(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaVeiculos(solicitaListaVeiculosResultHandler,event.paginaAtual);
		}
		public function atualizaListaVeiculos():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalListaVeiculos();
			TrafegusWS.getInstance().solicitaListaVeiculos(solicitaListaVeiculosResultHandler,0);
		}
		private function solicitaListaVeiculosResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().veiculosArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var veiculo:VeiculoVO = new VeiculoVO();
				veiculo.setVeiculoVO(obj);
				veiculo.count = i++;
				MainModel.getInstance().veiculosArray.addItem(veiculo);
			}
		}
		public function veiculosFilterFunction(item:Object):Boolean
		{
			return (String(VeiculoVO(item).cod).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
					(String(VeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
					(String(VeiculoVO(item).desc).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function veiculoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var selectedVehicleEvent:SelectedVehicleEvent = new SelectedVehicleEvent(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,VeiculoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(selectedVehicleEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum veiculo selecionado.");
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().veiculosArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaVeiculos():void
		{
			TrafegusWS.getInstance().solicitaTotalListaVeiculos(solicitaTotalListaVeiculosResultHandler);
		}
		private function solicitaTotalListaVeiculosResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaVeiculos = int(obj.total.toString());
			}
		}
		public function selectedVehicleEventHandler(event:SelectedVehicleEvent):void
		{
			event.stopImmediatePropagation();
			this.veiculoSelecionado();
		}
		public function mouseOverEventHandler():void
		{
			VehicleDetails.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchVeiculosEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraVeiculos(procuraVeiculosResultHandler,event.genericVO);
		}
		private function procuraVeiculosResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaVeiculos = 1;
			this.solicitaListaVeiculosResultHandler(event);
		}
		private function cadastroCavalos():void
		{
			var cadastroCavalos:CadastroCavalosView = new CadastroCavalosView();
			MyPopUpManager.addPopUp(cadastroCavalos,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(cadastroCavalos);
		}
		public function acoes(event:PopupButtonEvent):void
		{
			switch(event.label)
			{
				case "Selecionar":
					this.veiculoSelecionado();
					break;
				case "Editar":
					break;
				case "Adicionar":
					this.cadastroCavalos();
					break;
				case "Fechar":
					this.closeHandler();
					break;
				default:
					break;
			}
		}
	}
}