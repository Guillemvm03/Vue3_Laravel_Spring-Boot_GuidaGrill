<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StoreMesasRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        //return false;
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, mixed>
     */
    public function rules()
    {
        return [

            'numMesa' => 'required|integer|max:255',
            'capacidad' => 'required|integer|max:255', 
            'categoria' => 'required|string|max:255',
            'disponible' => 'required|boolean|[0,1]',
        ];
    }

    public function messages()
    {
        return [

            'numMesa.required' => 'El :attribute es obligatorio',
            'capacidad.required' => 'Añade un :attribute a la mesa bro',
            'categoria.required' => 'Añade un :attribute a la mesa bro',
            'disponible.required' => 'Añade un :attribute a la mesa bro',
        ];
    }
   
    public function attributes()
    {
        return [

            'numMesa' => 'numMesa of mesa',
            'capacidad' => 'capacidad of mesa',
            'categoria' => 'categoria of mesa',
            'disponible' => 'disponible of mesa',
        ];
    }
}
