package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.VehicleEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.CloseAppEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.DetailsEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesHistoricEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.MainView;
	import br.com.chapecosolucoes.trafegusweb.client.view.MainView2;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import com.google.maps.LatLng;
	
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	import mx.events.MenuEvent;

	public class MainController
	{
		public function MainController()
		{
		}
		public var view:MainView2;
		
		public function vehiclesReceivedEventHandler(event:VehiclesEvent):void
		{
			this.view.map.posicaoVeiculosArray(MainModel.getInstance().posVeiculosArray);
		}
		public function vehicleSelectedEventHandler(event:VehiclesEvent):void
		{
			this.view.map.posicaoVeiculoVO(MainModel.getInstance().posicaoVeiculoVO);
			this.view.details.posicaoVeiculoVO(MainModel.getInstance().posicaoVeiculoVO);
			if(event.enum == VehicleEnum.LIST)
			{
				this.view.details.selectedIndex = event.index;
			}
			else if(event.enum == VehicleEnum.DETAILS)
			{
				this.view.vehiclesView.selectedIndex = event.index;
			}
		}
		public function routeReceivedEventHandler(event:VehiclesHistoricEvent):void
		{
			this.view.map.rotaVeiculo(MainModel.getInstance().historicoPosicoesVeiculosArray);
		}
		public function closeApp(event:CloseEvent):void
		{
			/**
			 * For this to work in Firefox,
			 * Type in "about:config" in firefox address bar
			 * set dom.allow_scripts_to_close_windows to true.
			 */
			if(event.detail == Alert.OK)
			{
				//var urlString:String = "javascript:window.close();";
				//var request:URLRequest = new URLRequest(urlString);
				//navigateToURL(request, "_self");
				var closeEvent:CloseAppEvent = new CloseAppEvent(CloseAppEvent.CLOSE_APP_EVENT);
				this.view.dispatchEvent(closeEvent);
			}
		}
		public function closeEventHandler(event:CloseEvent):void
		{
			if(event.target.id.toString() == "veiculos")
			{
				this.view.veiculos.visible = !this.view.veiculos.visible;
				this.view.myMenuBar.menuBarItems[1].data.menuitem[0].@toggled = "false";
			}
			if(event.target.id.toString() == "mapa")
			{
				this.view.mapa.visible = !this.view.mapa.visible;
				this.view.myMenuBar.menuBarItems[1].data.menuitem[2].@toggled = "false";
			}
			if(event.target.id.toString() == "detalhes")
			{
				this.view.detalhes.visible = !this.view.detalhes.visible;
				this.view.myMenuBar.menuBarItems[1].data.menuitem[1].@toggled = "false";
			}
		}
		public function itemClickedHandler(event:MenuEvent):void
		{
			if(event.label == "Veiculos")
			{
				this.view.veiculos.visible = !this.view.veiculos.visible; 
			}
			if(event.label == "Mapa")
			{
				this.view.mapa.visible = !this.view.mapa.visible;	
			}
			if(event.label == "Detalhes")
			{
				this.view.detalhes.visible = !this.view.detalhes.visible;
			}
			if(event.label == "Salvar")
			{
				Alert.show("Configurações salvas com sucesso","Sucesso");
			}
			if(event.label == "Sair")
			{
				Alert.show("Deseja sair da aplicação","Sair",Alert.OK | Alert.CANCEL,this.view,this.closeApp);
			}
		}
	}
}