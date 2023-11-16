<?php

namespace App\Http\Controllers;

use App\Models\Table;
use Illuminate\Http\Request;
use App\Http\Resources\TableResource;

use App\Http\Requests\UpdateTableRequest;
use App\Http\Requests\StoreTableRequest;

class TableController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
          return TableResource::collection(Table::all());
    }

    /**
     * Show the form for creating a new resource.
     */


    /**
     * Store a newly created resource in storage.
     */

    public function store(StoreTableRequest $request)
    {
        return TableResource::make(Table::create($request->validated()));
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {

        return TableResource::make(Table::where('id', $id)->firstOrFail());

    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //

}

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateTableRequest $request, string $id)
    {
        //
    //     if (Mesas::where('id', $id)->exists()) {
    //         $mesas = Mesas::find($id);
    //         $mesas->numMesa = $request->numMesa;
    //         $mesas->capacidad = $request->capacidad;
    //         $mesas->categoria = $request->categoria;
    //         $mesas->disponible = $request->disponible;
    //         $student->save();
    //         return response()->json([
    //           "message" => "Mesa updated successfully"
    //         ], 200);

    // }

      if (Table::where('id', $id)->exists()) {
        $table = Table::find($id);

      $table->update($request->validated());
      return TableResource::make($table);
      }else {
      return response()->json([
        "message" => "Student not found"
      ], 404);
    } 


    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        if(Table::where('id', $id)->exists()) {
            $table = Table::find($id);
            $table->delete();
            return response()->json([
              "message" => "Mesa deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Mesa not found"
            ], 404);
          }
    }
}
