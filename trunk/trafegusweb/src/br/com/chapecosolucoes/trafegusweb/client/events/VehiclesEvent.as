package br.com.chapecosolucoes.trafegusweb.client.events
{
    import br.com.chapecosolucoes.trafegusweb.client.enum.VehicleEnum;
    
    import flash.events.Event;

    public class VehiclesEvent extends Event
    {
        public static const VEHICLES_RECEIVED_EVENT:String = "vehiclesReceivedEvent";

        public static const VEHICLE_SELECTED_EVENT:String = "vehicleSelectedEvent";

        private var _enum:VehicleEnum;

        public var index:int = 0;
		
		public var placa:String = "";

        public function VehiclesEvent(type:String, index:int = 0, enum:VehicleEnum = null,placa:String="", bubbles:Boolean = false, cancelable:Boolean = false)
        {
            this.index = index;
            this._enum = enum;
			this.placa = placa;
            super(type, bubbles, cancelable);
        }

        public override function clone():Event
        {
            return new VehiclesEvent(VEHICLES_RECEIVED_EVENT, index, enum, placa);
        }

        public function get enum():VehicleEnum
        {
            return this._enum;
        }
    }
}