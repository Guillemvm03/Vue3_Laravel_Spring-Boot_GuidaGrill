<?php

namespace App\Http\Controllers;

use App\Models\Table;
use Illuminate\Http\Request;
use App\Http\Resources\TableResource;
// use App\Http\Requests\StoreMesasRequest;
// use App\Http\Requests\UpdateMesasRequest;

class TableController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        // $mesas = Mesas::all();
    	//   return response()->json($mesas);



          return TableResource::collection(Table::all());

          
        //   return StudentResource::collection(Student::all());

        //   return Student::orderBy('numMesa', 'asc')->get();
        //   return StudentResource::collection(Student::orderBy('fname', 'asc')->paginate(2));
  
        //   return Student::offset(0)->limit(2)->get();Requests
        //   return StudentResource::collection(Student::offset(0)->limit(2)->get());
  
        //   $page = $request->has('page') ? $request->get('page') : 1;
        //   $limit = $request->has('limit') ? $request->get('limit') : 5;
        //   return StudentResource::collection(Student::limit($limit)->offset(($page - 1) * $limit)->get());
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
        //  @param  \Illuminate\Http\Request  $request
        //  @return \Illuminate\Http\Response
    }

    /**
     * Store a newly created resource in storage.
     */



    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //

        //         if(Mesas::where('id', $id)->exists()) {
        //     $mesas = Mesas::find($id);
        //     return response()->json([
        //       "message" => $mesas
        //     ], 202);
        // } else {
        //     return response()->json([
        //       "message" => "Mesa not found"
        //     ], 404);
        // }

        return MesasResource::make(Mesas::where('id', $id)->firstOrFail());

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
    public function update(UpdateMesasRequest $request, string $id)
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

      if (Mesas::where('id', $id)->exists()) {
        $mesas = Mesas::find($id);

      $mesas->update($request->validated());
      return MesasResource::make($mesas);
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
        if(Mesas::where('id', $id)->exists()) {
            $mesas = Mesas::find($id);
            $mesas->delete();
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
