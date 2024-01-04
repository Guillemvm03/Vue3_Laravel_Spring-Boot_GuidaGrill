<?php

namespace App\Http\Controllers;

use App\Http\Resources\ReservationResource; 
use App\Models\Reservation;
use Illuminate\Http\Request;

class ReservationController extends Controller {
    protected Reservation $reservation;

    public function index() {
        return ReservationResource::collection(Reservation::all());
    }

    public function show($id) {
        return ReservationResource::make(Reservation::findOrFail($id));
    }

    public function update(Request $request, $id) {
        $data = $request-> except(['id','user_id','table_id','reservation_time','reservation_day','capacity','msg']);
    
        $update = Reservation::where('id', $id)->update($data);
            if ($update == 1) {
                return response()->json([
                    "Message" => "Updated correctly"
                ]);
            } else {
                return response()->json([
                    "Status" => "Not found"
                ], 404);
            };
    }
}
