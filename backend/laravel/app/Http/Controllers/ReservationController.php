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

    public function update($id) {
    // Actualiza el campo 'approved' a true directamente
    $update = Reservation::where('id', $id)->update(['approved' => true]);

    if ($update == 1) {
        return response()->json([
            "Message" => "Updated correctly"
        ]);
    } else {
        return response()->json([
            "Status" => "Not found"
        ], 404);
    }
}
    public function destroy($id) {
        $reservation = Reservation::findOrFail($id);
        $reservation->delete();
        return response()->json([
            "Message" => "Deleted correctly"
        ]);
    }
}
