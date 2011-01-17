package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.LocaisZoom;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TipoTransporteZoom;
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.AddParadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedLocalEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoTransporteSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.AddParadasModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.AddParadasView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class AddParadasController
	{
		public function AddParadasController()
		{
		}
		public var view:AddParadasView;
		public var model:AddParadasModel;
		public function tipoParadaZoomDispatcher():void
		{
			var tipoTransporteZoom:TipoTransporteZoom = new TipoTransporteZoom();
			tipoTransporteZoom.addEventListener(TipoTransporteSelecionadoEvent.TIPO_TRANSPORTE_SELECIONADO_EVENT,tipoTransporteSelecionadoEventHandler);
			MyPopUpManager.addPopUp(tipoTransporteZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(tipoTransporteZoom);
		}
		public function localZoomDispatcher(enum:LocaisEnum):void
		{
			var locaisZoom:LocaisZoom = new LocaisZoom();
			if(enum == LocaisEnum.PARADA)
			{
				locaisZoom.addEventListener(SelectedLocalEvent.SELECTED_LOCAL_EVENT,paradaSelecionadoEventHandler);
			}
			MyPopUpManager.addPopUp(locaisZoom,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(locaisZoom);
		}
		public function closeHandler():void
		{
			MyPopUpManager.removePopUp(this.view);
		}
		private function paradaSelecionadoEventHandler(event:SelectedLocalEvent):void
		{
			this.model.parada.codigoReferencia = event.local.codigo;
			this.model.parada.descricaoReferencia = event.local.descricao;
		}
		private function tipoTransporteSelecionadoEventHandler(event:TipoTransporteSelecionadoEvent):void
		{
			this.model.parada.codigoTipoTransporte = event.tipoTransporte.codigo;
			this.model.parada.descricaoTipoTransporte = event.tipoTransporte.descricao;
		}
		public function paradaSelecionada():void
		{
			var paradaEvent:AddParadaEvent = new AddParadaEvent(AddParadaEvent.PARADA_ADICIONADA_EVENT,this.model.parada);
			this.view.dispatchEvent(paradaEvent);
			this.closeHandler();
		}
	}
}