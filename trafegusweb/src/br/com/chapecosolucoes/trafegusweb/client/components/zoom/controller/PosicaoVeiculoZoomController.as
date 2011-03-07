package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearch;
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearchVeiculosImpl;
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.model.PosicaoVeiculoZoomModel;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PosicaoVeiculoSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.VehicleDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.core.IFlexDisplayObject;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;
	import mx.utils.ObjectUtil;
	import mx.utils.object_proxy;

	public class PosicaoVeiculoZoomController extends BaseZoomController
	{
		public function PosicaoVeiculoZoomController()
		{
		}
		public var model:PosicaoVeiculoZoomModel;
		public function solicitaDadosGridZoom(event:PaginableEvent):void
		{
			event.stopImmediatePropagation();
			TrafegusWS.getInstance().solicitaDadosGridZoom(this.dadosGridZoomRecebidosHandler,event.paginaAtual);
		}
		private function procuraDadosGridHandler(event:ResultEvent):void
		{
			TrafegusWS.getInstance().removeEventListener("procuraDadosGrid",this.procuraDadosGridHandler);
			MainModel.getInstance().totalDadosGridZoom = 1;
			this.dadosGridZoomRecebidosHandler(event);
		}
		private function dadosGridZoomRecebidosHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().posVeiculosArrayZoom = new ArrayCollection();
			MainModel.getInstance().posVeiculosArrayZoom.filterFunction = posicaoVeiculosFilterFunction;
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var dataPos:PosicaoVeiculoVO = new PosicaoVeiculoVO(obj);
				dataPos.count = i++;
				if(dataPos.vehiclePlate != this.model.excluirVeiculoListaZoom)
				{
					MainModel.getInstance().posVeiculosArrayZoom.addItem(dataPos);
				}
				else
				{
					this.model.posicaoVeiculoVOExcluido = dataPos;
				}
			}
		}
		public function inicializaDadosGridZoom():void
		{
			//if(MainModel.getInstance().posVeiculosArrayZoom.length == 0)
			//{
				this.atualizaDadosGridZoom();
			//}
		}
		public function atualizaDadosGridZoom():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalDadosGridZoom();
			TrafegusWS.getInstance().solicitaDadosGridZoom(this.dadosGridZoomRecebidosHandler,0);
		}
		public function posicaoVeiculosFilterFunction(item:Object):Boolean
		{
			return (String(PosicaoVeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) || 
				(String(PosicaoVeiculoVO(item).gpsDescSis).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function veiculoSelecionado():void
		{
			if(this.view.grid.selectedIndex != -1)
			{
				var event:PosicaoVeiculoSelecionadaEvent = new PosicaoVeiculoSelecionadaEvent(PosicaoVeiculoSelecionadaEvent.POSICAO_VEICULO_SELECIONADA_EVENT,PosicaoVeiculoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum veiculo selecionado.");
			}
		}
		override public function closeHandler():void
		{
			MainModel.getInstance().posVeiculosArrayZoom.addItem(this.model.posicaoVeiculoVOExcluido);
			MyPopUpManager.removePopUp(IFlexDisplayObject(this.view));
		}
		public function advancedSearchClickEventHandler(event:AdvancedSearchEvent):void
		{
			var advancedSearch:AdvancedSearchVeiculosImpl = new AdvancedSearchVeiculosImpl();
			advancedSearch.addEventListener(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,advancedSearchEventHandler);
			MyPopUpManager.addPopUp(advancedSearch,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(advancedSearch);
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
		private function advancedSearchEventHandler(event:AdvancedSearchEvent):void
		{
			var posicaoVeiculoVO:PosicaoVeiculoVO = PosicaoVeiculoVO(event.genericVO);
			TrafegusWS.getInstance().procuraDadosGrid(procuraDadosGridHandler,posicaoVeiculoVO);
		}
		public function solicitaTotalDadosGridZoom():void
		{
			TrafegusWS.getInstance().solicitaTotalDadosGridZoom(solicitaTotalDadosGridResultHandler);
		}
		private function solicitaTotalDadosGridResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalDadosGridZoom = int(obj.total.toString());
			}
		}
	}
}