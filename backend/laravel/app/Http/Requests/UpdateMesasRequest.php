<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class UpdateMesasRequest extends FormRequest
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
            // 'fname' => 'sometimes|string|max:255',
            // 'lname' => 'sometimes|string|max:255',
            // 'email' => 'sometimes|string|max:255',
            // 'password' => 'sometimes|string|max:255',
            'numMesa' => 'required',
            'capacidad' => 'required',
            'categoria' => 'required',
            'disponible' => 'required',
        ];
    }
}
